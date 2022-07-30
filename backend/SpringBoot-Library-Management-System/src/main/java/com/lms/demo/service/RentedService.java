package com.lms.demo.service;

import com.lms.demo.model.Rented;

import java.util.List;

public interface RentedService {

    List<Rented> getAllRentedEntries();

    Rented save(Rented rented);

    String deleteByBookIdAndUserId(String bookId, String userId);

}
