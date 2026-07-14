import org.example.model.Admin;
import org.example.repository.AdminRepository;
import org.example.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// 1. ADICIONE ESTES IMPORTS ESTÁTICOS:
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    // Se o seu AdminService usa o PasswordEncoder, lembre-se de mocká-lo também se der erro de compilação:
    // @Mock
    // private PasswordEncoder passwordEncoder; 

    @InjectMocks
    private AdminService adminService;

    private Admin adminInput;

    @BeforeEach
    void setUp() {
        adminInput = new Admin(null, "Admin test", "admin@test.com", "pass123");
    }

    @Test
    @DisplayName("Deve salvar um admin com sucesso")
    void createAdminSucess() {
        // GIVEN (Preparação do teste)
        // Definindo o comportamento do Mockito: quando perguntar se o e-mail existe, responda que não (false)
        when(adminRepository.existsByEmail(adminInput.getEmail())).thenReturn(false);

        // Simulando que o banco de dados salvou e retornou o Admin com um ID gerado (ex: 1L)
        Admin adminSalvo = new Admin(1L, "Admin test", "admin@test.com", "pass123");
        when(adminRepository.save(any(Admin.class))).thenReturn(adminSalvo);

        // WHEN (Ação)
        // Chama o método que você quer testar de verdade
        Admin result = adminService.createAdmin(adminInput);

        // THEN (Verificação)
        // Garante que o retorno não é nulo e que os dados estão corretos
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Admin test", result.getFullName());
        assertEquals("admin@test.com", result.getEmail());

        // Opcional: Garante que o repository foi chamado exatamente uma vez para salvar
        verify(adminRepository, times(1)).save(any(Admin.class));
    }
}