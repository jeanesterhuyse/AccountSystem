package JeanEstProject.web.sb.controller;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.CreateAccountTypeFlow;
import JeanEstProject.logic.flow.FetchAccountTypeFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import JeanEstProject.domain.service.GeneralResponse;
import java.util.List;



@RestController
@RequestMapping("account-type")
public class AccountTypeController {
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName")CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow=fetchAccountTypeFlow;
        this.createAccountTypeFlow=createAccountTypeFlow;
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

    @PostMapping("")
    @ApiOperation(value = "Create new account type", notes = "New account type in database")
    @ApiResponses(value = {
            @ApiResponse(code=201, message = "Account type created",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDTO>>create(
            @ApiParam(value = "Request for new accounttype",required = true)
            @RequestBody AccountTypeDTO accountType){
        AccountTypeDTO accountTypeResponse=createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDTO> response=new GeneralResponse<>(true,accountTypeResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetch specified account", notes = "Fetch type according to mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Goal found",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountTypeDTO>> getAccountType(
            @ApiParam(value = "Mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic){

        AccountTypeDTO accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDTO> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
