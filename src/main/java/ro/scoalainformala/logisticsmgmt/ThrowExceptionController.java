package ro.scoalainformala.logisticsmgmt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.scoalainformala.logisticsmgmt.exceptions.UnprocessableEntityException;

@RestController
@RequestMapping("/exception")
public class ThrowExceptionController {


    @GetMapping
    public void throwException() {
        throw new UnprocessableEntityException("Unable to process entity");
    }
}
