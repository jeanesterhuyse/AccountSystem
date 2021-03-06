package JeanEstProject.web.sb.controller;
import JeanEstProject.domain.dto.AccountTypeDTO;
import JeanEstProject.logic.flow.CreateAccountTypeFlow;
import JeanEstProject.logic.flow.FetchAccountTypeFlow;
import JeanEstProject.logic.flow.ModifyAccountTypeFlow;
import JeanEstProject.translator.impl.AccountTypeTranslatorimpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import JeanEstProject.domain.service.GeneralResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountTypeController.class);

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final ModifyAccountTypeFlow modifyAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName")CreateAccountTypeFlow createAccountTypeFlow,
                                 ModifyAccountTypeFlow modifyAccountTypeFlow){
        this.fetchAccountTypeFlow=fetchAccountTypeFlow;
        this.modifyAccountTypeFlow=modifyAccountTypeFlow;
        this.createAccountTypeFlow=createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all configured account types",notes = "returns list")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Account types returned",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<List<AccountTypeDTO>>>getAll(){
        LOGGER.info("getAll mapped succesfully");
        List<AccountTypeDTO>accountTypes=fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDTO>>response=new GeneralResponse<>(true,accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new account type", notes = "New account type in database")
    @ApiResponses(value = {
            @ApiResponse(code=201, message = "New account type created",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDTO>>create(
            @ApiParam(value = "Request for new accounttype",required = true)
            @RequestBody AccountTypeDTO accountType){
            LOGGER.info("Create method mapped");
             AccountTypeDTO accountTypeResponse=createAccountTypeFlow.create(accountType);
             GeneralResponse<AccountTypeDTO> response=new GeneralResponse<>(true,accountTypeResponse);
             return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetch specified account", notes = "Fetch accounttype according to mnemonic")
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
        LOGGER.info("getAccountType mapped");
        AccountTypeDTO accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDTO> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Delete accounttyppe", notes = "Delete account type according to mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Deleted",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountTypeDTO>> deleteAccountType(
            @ApiParam(value = "Mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic){
        LOGGER.info("deleteAccountType mapped");
        AccountTypeDTO accountType =modifyAccountTypeFlow.deleteAccountType(mnemonic);
        GeneralResponse<AccountTypeDTO> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("{mnemonic}")
    @ApiOperation(value = "Update accounttyppe", notes = "Update account type according to mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Updated",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountTypeDTO>> updateAccountType(
            @ApiParam(value = "Mnemonic that uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic,

    @ApiParam(value = "The new AccountTypes that AccountType should be updated with.",
            name = "newAccountTypeName",
            required = true)
    @RequestParam("newAccountTypeName") final String newAccountTypeName,
    @ApiParam(value = "The new date  to update the CreationDate is ISO date format (yyyy-MM-dd)\r\n",
            name = "newDateCreated",
            required = true)
    @RequestParam(value = "newDateCreated", required = false)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
                    LocalDate newDateCreated
    ) {
        LOGGER.info("updateAccountType mapped");
        AccountTypeDTO accountType = modifyAccountTypeFlow.updateAccountType(mnemonic, newAccountTypeName, newDateCreated);
        GeneralResponse<AccountTypeDTO> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }



}
