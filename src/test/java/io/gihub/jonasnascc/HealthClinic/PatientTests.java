package io.gihub.jonasnascc.HealthClinic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gihub.jonasnascc.HealthClinic.controller.PatientController;
import io.gihub.jonasnascc.HealthClinic.dto.PatientDTO;
import io.gihub.jonasnascc.HealthClinic.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PatientController.class)
@ActiveProfiles("test")
public class PatientTests {
    private static final String END_POINT_PATH = "/api/patients";

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @MockBean private PatientService patientService;

    @Test
    public void createPatient_shouldReturn2xxSuccessfull() throws Exception {
        PatientDTO dto = new PatientDTO(
                "716.286.210-10",
                "Jonas",
                "Nascimento",
                "jonasnascimento@mail.com",
                "83999092388",
                "California Hawaii, 210 st"
        );

        String requestBody = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post(END_POINT_PATH).contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createPatient_shouldReturn400BadRequest() throws Exception {
        PatientDTO dto = new PatientDTO(
                "122.454.333-00",
                "Jonas",
                "Nascimento",
                "jonasnascimento_mail.com",
                "",
                ""
        );

        String requestBody = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post(END_POINT_PATH).contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());

    }
}
