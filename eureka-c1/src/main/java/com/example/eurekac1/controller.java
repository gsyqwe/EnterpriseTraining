package com.example.eurekac1;

import com.example.eurekac1.model.College;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class controller {

    @RequestMapping("get/{id}")
    public College get(@PathVariable Integer id){
        College college = new College();
        switch (id){
            case 1:
                college.setId(1);
                college.setName("南京大学");
                college.setAddress("仙林大学城");
                college.setPhone("00001");
                break;
            case 2:
                college.setId(2);
                college.setName("南京师范大学");
                college.setAddress("仙林大学城");
                college.setPhone("00002");
                break;
            case 3:
                college.setId(3);
                college.setName("东南大学");
                college.setAddress("四牌楼校区");
                college.setPhone("00003");
                break;
        }
        return college;
    }


}
