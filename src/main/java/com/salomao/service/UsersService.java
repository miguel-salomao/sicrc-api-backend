package com.salomao.service;

import com.salomao.dtos.UsersDto;
import com.salomao.model.UsersModel;
import com.salomao.repository.UsersRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UsersService {

    @Inject
    private UsersRepository usersRepository;

    public void createUser(UsersDto usersDto) {
        usersRepository.persist(mapUserDtoToEntity(usersDto));
    }

    private UsersDto mapUserModelToDto(UsersModel usersModel) {
        UsersDto usersDto = new UsersDto();

        usersDto.setAge(usersModel.getAge());
        usersDto.setEmail(usersModel.getEmail());
        usersDto.setName(usersModel.getName());
        usersDto.setPhone(usersModel.getPhone());
        usersDto.setPassword(usersModel.getPassword());
        usersDto.setRegistration(usersModel.getRegistration());
        return usersDto;
    }

    private UsersModel mapUserDtoToEntity(UsersDto usersDto) {
        UsersModel usersModel = new UsersModel();
        usersModel.setAge(usersDto.getAge());
        usersModel.setEmail(usersDto.getEmail());
        usersModel.setName(usersDto.getName());
        usersModel.setPassword(usersDto.getEmail());
        usersModel.setPhone(usersDto.getPhone());
        usersModel.setRegistration(usersDto.getRegistration());
        return usersModel;
    }


    public List<UsersModel> findAll(Integer page, Integer pageSize) {
        return usersRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public UsersDto findById(Long id) {
        return mapUserModelToDto(usersRepository.findById(id));
    }
}
