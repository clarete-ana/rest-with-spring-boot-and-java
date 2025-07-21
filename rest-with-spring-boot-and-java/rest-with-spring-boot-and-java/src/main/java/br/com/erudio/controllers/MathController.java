package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService service;

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        validate(numberOne,numberTwo);
        return service.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        validate(numberOne,numberTwo);
        return service.subtraction(convertToDouble(numberOne),convertToDouble(numberTwo));
    }
    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double divison(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        validate(numberOne,numberTwo);
        return service.division(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        validate(numberOne,numberTwo);
        return service.multiplication(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/average/3/5
    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        validate(numberOne,numberTwo);
        return service.average(convertToDouble(numberOne) ,convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/sqrt/3
    @RequestMapping("/sqrt/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    ) throws Exception {
        validate(number);
        return service.squareRoot(convertToDouble(number));
    }


    private Double convertToDouble(String strNumber){
        if(strNumber == null | strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {

        if(strNumber == null | strNumber.isEmpty())
            return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public void validate(String ... numbers){
        for(String number : numbers){
            if(!isNumeric(number))
                throw new UnsupportedMathOperationException("Please set a numeric value");
        }
    }
}
