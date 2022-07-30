package com.lms.demo.service.impl;

import com.lms.demo.exceptionHandler.ObjectAlreadyExists;
import com.lms.demo.exceptionHandler.ObjectDoNotExists;
import com.lms.demo.model.Rented;
import com.lms.demo.repository.RentedRepository;
import com.lms.demo.service.RentedService;
import com.lms.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentedServiceImpl implements RentedService {

    @Autowired
    RentedRepository rentedRepository;

    @Override
    public List<Rented> getAllRentedEntries() {
        List<Rented> allRented = rentedRepository.findAll();
        if(allRented.isEmpty())
            throw new ObjectDoNotExists(Constants.RENTED_NOT_FOUND);
        return allRented;
    }

    @Override
    public Rented save(Rented rented) {
        Rented rentedExists = rentedRepository.findByBook_IdAndUser_Id(rented.getBook().getId(), rented.getUser().getId());
        if(rentedExists != null)
            throw new ObjectAlreadyExists(Constants.RENTED_ALREADY_EXISTS);
        return rentedRepository.save(rented);
    }

    @Override
    public String deleteByBookIdAndUserId(String bookId, String userId) {
        rentedRepository.deleteByBook_IdAndUser_Id(bookId, userId);
        return "Entry has been deleted successfully";
    }
}
