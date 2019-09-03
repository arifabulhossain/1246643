package com.aharif.hospitalManagement.repo;



import com.aharif.hospitalManagement.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface PaymentInfoRepo extends JpaRepository<PaymentInfo,Long> {


    PaymentInfo findByPaymentDate(Date paymentDate);
    boolean existsPaymentInfoByPaymentDate(Date paymentDate);

Iterable<PaymentInfo> findAllByPaymentDate(Date paymentDate);

}
