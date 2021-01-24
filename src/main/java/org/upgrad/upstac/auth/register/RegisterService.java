package org.upgrad.upstac.auth.register;

import org.slf4j.Logger;
import java.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.roles.UserRole;
import java.time.*;
import org.upgrad.upstac.users.models.*;


@Service











































































public class RegisterService {

    @Autowired
    private UserService userService;


    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);


    public User addUser(RegisterRequest registerRequest) {
    	User user = null;
    	if(((userService.findByUserName(registerRequest.getUserName()))==null) && ((userService.findByPhoneNumber(registerRequest.getPhoneNumber()))==null) && ((userService.findByEmail(registerRequest.getEmail()))==null)) 
    	{
    		user=new User();
    		
    		user.setEmail(registerRequest.getEmail());
    		user.setUserName(registerRequest.getUserName());
    		//user.setPassword(registerRequest.getPassword());
    		user.setPassword(userService.toEncrypted(registerRequest.getPassword()));
    		user.setFirstName(registerRequest.getFirstName());
    		user.setPhoneNumber(registerRequest.getPhoneNumber());
    		user.setLastName(registerRequest.getLastName());
    		user.setAddress(registerRequest.getAddress());
    		user.setPinCode(registerRequest.getPinCode());
    		user.setGender(registerRequest.getGender());
    		user.setDateOfBirth(LocalDate.parse(registerRequest.getDateOfBirth()));
    		
    		user.setRoles(userService.getRoleFor(UserRole.USER));
    		user.setStatus(AccountStatus.APPROVED);
    		
    		userService.saveInDatabase(user);
        	//return user;
    		
    	}
    	else if((userService.findByUserName(registerRequest.getUserName()))!=null){
    		throw new AppException("This UserName is already in use.");
    	}
    	else if((userService.findByPhoneNumber(registerRequest.getPhoneNumber()))==null) {
    		throw new AppException("This Phone Number is already un use.");
    	}
    	else if((userService.findByEmail(registerRequest.getEmail()))==null) {
    		throw new AppException("This Email address is already un use.");

    	}
		return user;
    	
    

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

/*      User should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.USER)
                status should be set to AccountStatus.APPROVED

        And finally
            Call userService.saveInDatabase to save the new user and return the saved user
*/

      // throw new AppException("Method Not Implemented");
    }

    public User addDoctor(RegisterRequest user) {


/*      Doctor should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.DOCTOR)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save the newly registered doctor and return the saved value
*/
        throw new AppException("Method Not Implemented");
    }


    public User addTester(RegisterRequest user) {


/*      Tester should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.TESTER)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save newly registered tester and return the saved value
*/

        throw new AppException("Method Not Implemented");
    }


}
