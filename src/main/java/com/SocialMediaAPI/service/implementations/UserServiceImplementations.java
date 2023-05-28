package com.SocialMediaAPI.service.implementations;

import com.SocialMediaAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImplementations {
//    implements
//} UserDetailsService {
//
//    @Autowired
//    private final UserRepository userRepository;
//
//
//    public UserServiceImplementations(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        System.out.println(email);
//        User.UserBuilder builder = null;
//        com.SocialMediaAPI.model.User user = userRepository.findByEmail(email);
//        System.out.println(email);
//        if (user == null) {
//            throw new UsernameNotFoundException(email);
//        } else {
//            builder = org.springframework.security.core.userdetails.User.withUsername(email);
//            builder.password(user.getPassword());
////            builder.roles(user.getRole());
//        }
//        return builder == null ? null : builder.build();
//    }
//
//        @Override
//        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//            return userRepository.findByEmail(email);
//        }
}
//    @Autowired
//    private final UserDataRepository usersData;
//    @Autowired
//    private final SyncUser syncUser;
//
//    public UserServiceImplementation(UserDataRepository usersData, SyncUser syncUser) {
//
//        this.usersData = usersData;
//
//        this.syncUser = syncUser;
//    }

//    @Override
//    public Optional<User> getDataByLogin(String login){
//        return Optional.ofNullable( usersData.findByLogin(login));
//    }
//
//    @Override
//    public Optional<User> getDataById(int id) {
//        return usersData.findById(id);
//    }
//
//    @Override
//    public List<UsersData> getAll() {
//        return usersData.findAll();
//    }
//
//    @Override
//    public Page<UsersData> findByFio( Pageable pageable, String keywords ) {
//        return usersData.findUsersDataWithPartOfFamilyname( pageable, keywords);
//    }
//
//    @Override
//    public UsersData saveUser(UsersData user) {
//        return usersData.save(user);
//    }
//
//    @Override
//    public Page<UsersData> findAll( Pageable pageable) {
//        return usersData.findAll( pageable);
//    }
//
//    @Override
//    public Optional<UsersData> findByEmailSkipr(String email) throws IOException, ParseException {
//        return syncUser.getUserByEmail(email);
//    }
//
//    @Override
//    public Optional<UsersData> findByLoginSkipr(String login) throws IOException, ParseException {
//        return syncUser.getUserByLogin(login);
//    }

