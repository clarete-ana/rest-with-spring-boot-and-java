package br.com.erudio.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double average(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo)/2;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }


}
