package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.ISmartPhoneService;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/phones-rest")
public class SmartPhoneRestController {
    @Autowired
    private ISmartPhoneService smartphoneService;

    @GetMapping("/list")
    public ResponseEntity<Page<SmartPhone>> getPageSmartPhone(@PageableDefault(value = 3) Pageable pageable) {
        Page<SmartPhone> smartPhones = this.smartphoneService.findAll(pageable);

        if (!smartPhones.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createSmartPhone(@RequestBody SmartPhone smartPhone,
                                                             BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        this.smartphoneService.save(smartPhone);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id) {
        Optional<SmartPhone> smartPhoneOptional = smartphoneService.findById(id);
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartPhoneOptional.get(), HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/edit/{id}")
//    public SmartPhone editSmartPhone(@RequestBody SmartPhone smartPhone,
//                                     @PathVariable Long id) {
//        return smartphoneService.findById(id).map(
//                smartPhone1 -> {
//                    smartPhone.setProducer(smartPhone1.getProducer());
//                    smartPhone.setModel(smartPhone1.getModel());
//                    smartPhone.setPrice(smartPhone1.getPrice());
//                    return smartphoneService.save(smartPhone1);
//                }).orElseGet(() ->{
//                    smartPhone.setId(id);
//                    return smartphoneService.save(smartPhone);
//        });
//    }


    @PutMapping("/edit/{id}")
    public  ResponseEntity<SmartPhone> editSmartPhone(@RequestBody SmartPhone smartPhone,
                                     @PathVariable Long id) throws NotEmpty {
//        SmartPhone a =  smartphoneService.findById(id).map(
//                smartPhone1 -> {
//                    smartPhone.setProducer(smartPhone1.getProducer());
//                    smartPhone.setModel(smartPhone1.getModel());
//                    smartPhone.setPrice(smartPhone1.getPrice());
//                    return smartphoneService.save(smartPhone1);
//                }).orElseGet(() ->{
//            smartPhone.setId(id);
//            return smartphoneService.save(smartPhone);
//        });

        smartphoneService.findById(id).orElseThrow(NotEmpty::new);

        smartPhone.setId(id);
        SmartPhone a = smartphoneService.save(smartPhone);

         return new ResponseEntity<>(a, HttpStatus.NO_CONTENT);
    }


}
