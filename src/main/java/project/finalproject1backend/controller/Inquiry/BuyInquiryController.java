package project.finalproject1backend.controller.Inquiry;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import project.finalproject1backend.dto.ErrorDTO;
import project.finalproject1backend.dto.PrincipalDTO;
import project.finalproject1backend.dto.ResponseDTO;
import project.finalproject1backend.dto.inquiry.BuyInquiryDTO;
import project.finalproject1backend.dto.product.ProductFormDto;
import project.finalproject1backend.dto.user.UserSignUpRequestDTO;
import project.finalproject1backend.service.Inquiry.BuyInquiryService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class BuyInquiryController {

    private final BuyInquiryService buyInquiryService;

    @Tag(name = "API 문의하기", description = "문의하기 api 입니다.")
    @Operation(summary = "구매 문의생성 메서드", description = "구매 문의생성 메서드입니다.",security ={ @SecurityRequirement(name = "bearer-key")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
    })
    @PostMapping(value = "/account/buyInquiry/register",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buyInquiryCreat (@Parameter(hidden = true)@AuthenticationPrincipal PrincipalDTO principal, @RequestPart(value = "requestDTO") @Valid BuyInquiryDTO requestDTO,
                                              BindingResult bindingResult, @RequestPart(required = false) List<MultipartFile> buyImageList) {

        return buyInquiryService.buyInquiryCreat(requestDTO, buyImageList, principal);
    }

}
