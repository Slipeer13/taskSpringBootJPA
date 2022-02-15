package com.example.taskSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private SalesProductJPARepository salesRepository;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<SalesPeriod> getAllSales() {
        // This returns a JSON or XML with the users
        return salesRepository.findAll();
    }
    @GetMapping(path="/count")
    public @ResponseBody
    Long getAllSalesCount() {
        // This returns a JSON or XML with the users
        return salesRepository.count();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Optional<SalesPeriod> getAllSalesFromId(@PathVariable("id") int id) {
        return salesRepository.findById(id);
    }

    @GetMapping(value = "/insert/{date_from}/{date_to}/{price}")
    public @ResponseBody
    void setSales(@PathVariable("date_from") String date_from, @PathVariable("date_to") String date_to, @PathVariable("price") int price) {
        salesRepository.save(new SalesPeriod(date_from, date_to, price));
    }
    @GetMapping(path="/exist/price")
    public @ResponseBody
    boolean existByPrice() {
        boolean result = false;
        for (SalesPeriod s:
             salesRepository.findAll()) {
            if (s.getPrice() > 100) {
                result = true;
                break;
            }
        }
        return result;
    }
}
