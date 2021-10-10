package JeanEstProject.web.sb.controller;
import JeanEstProject.domain.dto.AccountUserDTO;
import JeanEstProject.logic.flow.CreateAccountUserFlow;
import JeanEstProject.logic.flow.FetchAccountUserFlow;
import JeanEstProject.logic.flow.ModifyAccountUserFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import JeanEstProject.domain.service.GeneralResponse;
import java.util.List;

@RestController
@RequestMapping("account-user")
public class AccountUserController {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountUserController.class);

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
        LOGGER.info("getAll mapped succesfully");
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
            LOGGER.info("Create mapped succesfully");
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
        LOGGER.info("getAccountUser mapped succesfully");
        AccountUserDTO accountUser = fetchAccountUserFlow.getAccountUserByMemberID(MemberID);
        GeneralResponse<AccountUserDTO> response = new GeneralResponse<>(true, accountUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("add/{add}")
    @ApiOperation(value = "Add units", notes = "Add units to members total")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Updated",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountUserDTO>> addUnits(
            @ApiParam(value = "MemberID that uniquely identifies the user.",
                    example = "112",
                    name = "MemberID",
                    required = true)
            @PathVariable("add") final String memberID,

            @ApiParam(value = "The new total units that the table should be updated with.",
                    name = "newTotalUnits",
                    example = "1",
                    required = true)
            @RequestParam("units") final Long units) {
        LOGGER.info("addUnits mapped succesfully");
        AccountUserDTO accountUser = modifyAccountUserFlow.addUnits(units,memberID);
        GeneralResponse<AccountUserDTO> response = new GeneralResponse<>(true, accountUser);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("subtract/{subtract}")
    @ApiOperation(value = "subtract units", notes = "subtracts units from members total")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "Updated",response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Bad request",response = GeneralResponse.class),
            @ApiResponse(code=404, message = "Resource not found",response = GeneralResponse.class),
            @ApiResponse(code=500, message = "Internal server error",response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<AccountUserDTO>> subtractUnits(
            @ApiParam(value = "MemberID that uniquely identifies the user.",
                    example = "112",
                    name = "MemberID",
                    required = true)
            @PathVariable("add") final String memberID,

            @ApiParam(value = "Units that should be subtracted.",
                    name = "newTotalUnits",
                    example = "1",
                    required = true)
            @RequestParam("units") final Long units) {
        LOGGER.info("subtractUnits mapped succesfully");
        AccountUserDTO accountUser = modifyAccountUserFlow.subtractUnits(units,memberID);
        GeneralResponse<AccountUserDTO> response = new GeneralResponse<>(true, accountUser);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }






}
