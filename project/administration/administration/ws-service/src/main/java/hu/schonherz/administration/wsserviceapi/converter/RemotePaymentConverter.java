package hu.schonherz.administration.wsserviceapi.converter;

import hu.schonherz.administration.serviceapi.dto.PaymentMethod;
import hu.schonherz.administration.wsservice.dto.RemotePaymentMethod;

public class RemotePaymentConverter {

	public static RemotePaymentMethod toRemoteDTO(PaymentMethod payment) {
		if (payment == null) {
			return null;
		}
		switch (payment) {
		case Cash:
			return RemotePaymentMethod.Cash;

		case SZEPCard:
			return RemotePaymentMethod.SZEPCard;

		case CreditCard:
			return RemotePaymentMethod.CreditCard;

		case VOUCHER:
			return RemotePaymentMethod.VOUCHER;

		}
		return null;
	}

	public static PaymentMethod toDTO(RemotePaymentMethod paymentMethod) {
		if (paymentMethod == null) {
			return null;
		}
		switch (paymentMethod) {
		case Cash:
			return PaymentMethod.Cash;

		case SZEPCard:
			return PaymentMethod.SZEPCard;

		case CreditCard:
			return PaymentMethod.CreditCard;

		case VOUCHER:
			return PaymentMethod.VOUCHER;

		}
		return null;
	}

}
