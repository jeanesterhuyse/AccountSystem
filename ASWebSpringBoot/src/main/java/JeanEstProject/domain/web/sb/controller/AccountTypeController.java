package JeanEstProject.domain.web.sb.controller;
import JeanEstProject.domain.dto.AccountTypeDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import JeanEstProject.domain.service.GeneralResponse;

import java.util.List;

import JeanEstProject.logic.flow.FetchAccountTypeFlow;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {
    public final FetchAccountTypeFlow fetchAccountTypeFlow;
    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow){
        this.fetchAccountTypeFlow=fetchAccountTypeFlow;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets configured account types",notes = "returns list")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Account types returned",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTypeDTO>>>getAll(){
        List<AccountTypeDTO>accountTypes=fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDTO>>response=new GeneralResponse<>(true,accountTypes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
