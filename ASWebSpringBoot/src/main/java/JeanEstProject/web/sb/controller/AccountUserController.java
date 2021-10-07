package JeanEstProject.web.sb.controller;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.CreateAccountUserFlow;
import JeanEstProject.logic.flow.FetchAccountUserFlow;
import JeanEstProject.logic.flow.ModifyAccountUserFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("account-user")
public class AccountUserController {
    private final FetchAccountUserFlow fetchAccountUserFlow;
    private final CreateAccountUserFlow createAccountUserFlow;
    private final ModifyAccountUserFlow modifyAccountUserFlow;
    @Autowired
    public AccountUserController(FetchAccountUserFlow fetchAccountUserFlow,
                                 @Qualifier("createAccountUserFlowName")CreateAccountUserFlow createAccountUserFlow,
                                 ModifyAccountUserFlow modifyAccountUserFlow){
        this.fetchAccountUserFlow=fetchAccountUserFlow;
        this.createAccountUserFlow=createAccountUserFlow;
        this.modifyAccountUserFlow=modifyAccountUserFlow;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets account Users",notes = "returns list")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Account users returned",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<List<AccountUserDTO>>>getAll(){
        List<AccountUserDTO>accountUsers=fetchAccountUserFlow.getAllAccountUsers();
        GeneralResponse<List<AccountUserDTO>>response=new GeneralResponse<>(true,accountUsers);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create new account User", notes = "New account User in database")
    @ApiResponses(value = {
            @ApiResponse(code=201, message = "Account User created",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountUserDTO>>create(
            @ApiParam(value = "Request for new accountUser",required = true)
            @RequestBody AccountUserDTO accountUser){
        AccountUserDTO accountUserResponse=createAccountUserFlow.create(accountUser);
        GeneralResponse<AccountUserDTO> response=new GeneralResponse<>(true,accountUserResponse);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("{MemberID}")
    @ApiOperation(value = "Fetch specified account", notes = "Fetch User according to MemberID")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Goal found",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountUserDTO>> getAccountUser(
            @ApiParam(value = "MemberID that uniquely identifies the AccountUser.",
                    example = "123",
                    name = "MemberID",
                    required = true)
            @PathVariable("MemberID") final String MemberID){

        AccountUserDTO accountUser = fetchAccountUserFlow.getAccountUserByMemberID(MemberID);
        GeneralResponse<AccountUserDTO> response = new GeneralResponse<>(true, accountUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("{MemberID}")
    @ApiOperation(value = "Delete account user", notes = "Delete account user according to MemberID")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Deleted",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountUserDTO>> deleteAccountUser(
            @ApiParam(value = "MemberID that uniquely identifies the account user.",
                    example = "123",
                    name = "MemberID",
                    required = true)
            @PathVariable("MemberID") final String MemberID){

        AccountUserDTO accountUser =modifyAccountUserFlow.deleteAccountUser(MemberID);
        GeneralResponse<AccountUserDTO> response = new GeneralResponse<>(true, accountUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("{MemberID}")
    @ApiOperation(value = "Update account user details", notes = "Update account User according to MemberID")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Updated",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountUserDTO>> updateAccountUser(
            @ApiParam(value = "MemberID that uniquely identifies the user.",
                    example = "123",
                    name = "MemberID",
                    required = true)
            @PathVariable("MemberID") final String memberID,

            @ApiParam(value = "The new member that the table should be updated with.",
                    name = "newMemberName",
                    required = true)
            @RequestParam("newMemberName") final String newMemberName,
            @ApiParam(value = "The new date to update the date joined is ISO date format (yyyy-MM-dd)\r\n",
                    name = "newDateJoined",
                    required = true)
            @RequestParam(value = "newDateJoined", required = false)
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
                    LocalDate newDateJoined,
            @ApiParam(value = "The new total miles that the table should be updated with.",
                    name = "newTotalMiles",
                    required = true)
            @RequestParam("newTotalMiles") final Long newTotalMiles)




     {

        AccountUserDTO accountUser = modifyAccountUserFlow.updateAccountUser(memberID, newMemberName, newDateJoined, newTotalMiles);
        GeneralResponse<AccountUserDTO> response = new GeneralResponse<>(true, accountUser);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }



}
