package com.example.lab4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
}
