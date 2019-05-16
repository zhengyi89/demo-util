package com.test.optimisticLock;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.test.bean.AccountWallet;
import com.test.service.AccountWalletService;

/**
 * 用户钱包Controller
 * 
 * @author zzg
 * @date 2017-02-10
 */

@Controller
@RequestMapping(value = "/wallet")
public class WalletController {

	@Autowired
	private AccountWalletService accountWalletService;

	/**
	 * 针对业务系统高并发-----修改用户钱包数据余额，采用乐观锁
	 * 
	 * @return
	 */
	@RequestMapping(value = "/walleroptimisticlock.action", method = RequestMethod.POST)
	@ResponseBody
	public String walleroptimisticlock(HttpServletRequest request) {

		String result = "";

		try {
			String openId = request.getParameter("openId") == null ? null : request.getParameter("openId").trim(); // 用户唯一编号
			String openType = request.getParameter("openType") == null ? null : request.getParameter("openType").trim(); // 1:代表增加，2：代表减少
			String amount = request.getParameter("amount") == null ? null : request.getParameter("amount").trim(); // 金额

			if (StringUtils.isEmpty(openId)) {
				return "openId is null";
			}
			if (StringUtils.isEmpty(openType)) {
				return "openType is null";
			}
			if (StringUtils.isEmpty(amount)) {
				return "amount is null";
			}
			AccountWallet wallet = accountWalletService.selectByOpenId(openId);

			// 用户操作金额
			BigDecimal cash = BigDecimal.valueOf(Double.parseDouble(amount));
			cash.doubleValue();
			cash.floatValue();
			if (Integer.parseInt(openType) == 1) {
				wallet.setUserAmount(wallet.getUserAmount().add(cash));
			} else if (Integer.parseInt(openType) == 2) {
				wallet.setUserAmount(wallet.getUserAmount().subtract(cash));
			}

			int target = accountWalletService.updateAccountWallet(wallet);
			System.out.println("修改用户金额是否：" + (target == 1 ? "成功" : "失败"));

		} catch (Exception e) {
			result = e.getMessage();
			return result;
		}

		return "success";
	}

}