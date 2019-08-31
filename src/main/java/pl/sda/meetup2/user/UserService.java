package pl.sda.meetup2.user;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.sda.meetup2.dto.RegisterFormDto;
import pl.sda.meetup2.exception.UserExistsException;

@Service
public class UserService {

    private final UserDao userDao;
    private final DtoToUserConverter dtoToUserConverter;

    public UserService(UserDao userDao, DtoToUserConverter dtoToUserConverter) {
        this.userDao = userDao;
        this.dtoToUserConverter = dtoToUserConverter;
    }

    public void saveUserToDb(RegisterFormDto registerFormDto) {
        if (userDao.findUserInDb(registerFormDto.getEmail()).isEmpty()) {
            userDao.saveUserToDb(dtoToUserConverter.rewriteDtoToUser(registerFormDto));
        } else {
            throw new UserExistsException("user already exists!");
        }
    }

    public String getLoggedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        return authentication.getName();
    }
}
