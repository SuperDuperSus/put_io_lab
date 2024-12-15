package put.io.testing.mocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;
import java.util.Arrays;

public class ExpenseManagerTest {
    @Test
    void testCalculateTotal(){
        ExpenseRepository mocked_Expense_Repository = mock(ExpenseRepository.class);
        FancyService mocked_Fancy_Service = mock(FancyService.class);

        List<Expense> expenses = new ArrayList<>();
        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        Expense expense3 = new Expense();
        expense1.setAmount(30);
        expense1.setCategory("test");
        expense1.setTitle("test");
        expense2.setAmount(20);
        expense2.setCategory("test2");
        expense2.setTitle("test2");
        expense3.setAmount(10);
        expense3.setCategory("test3");
        expense3.setTitle("test3");
        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);

        when(mocked_Expense_Repository.getExpenses()).thenReturn(expenses);
        ExpenseManager expenseManager = new ExpenseManager(mocked_Expense_Repository, mocked_Fancy_Service);
        assertEquals(60, expenseManager.calculateTotal());
    }
    @Test
    void testCalculateTotalForCategory() {
        ExpenseRepository mockedExpenseRepository = mock(ExpenseRepository.class);
        FancyService mockedFancyService = mock(FancyService.class);

        Expense homeExpense1 = new Expense();
        homeExpense1.setAmount(100);
        homeExpense1.setCategory("Home");

        Expense homeExpense2 = new Expense();
        homeExpense2.setAmount(200);
        homeExpense2.setCategory("Home");

        Expense carExpense = new Expense();
        carExpense.setAmount(300);
        carExpense.setCategory("Car");

        when(mockedExpenseRepository.getExpensesByCategory(eq("Home")))
                .thenReturn(Arrays.asList(homeExpense1, homeExpense2));

        when(mockedExpenseRepository.getExpensesByCategory(eq("Car")))
                .thenReturn(Collections.singletonList(carExpense));

        when(mockedExpenseRepository.getExpensesByCategory(argThat(category ->
                !category.equals("Home") && !category.equals("Car"))))
                .thenReturn(Collections.emptyList());

        ExpenseManager expenseManager = new ExpenseManager(mockedExpenseRepository, mockedFancyService);

        assertEquals(300, expenseManager.calculateTotalForCategory("Home"));
        assertEquals(300, expenseManager.calculateTotalForCategory("Car"));
        assertEquals(0, expenseManager.calculateTotalForCategory("Food"));
        assertEquals(0, expenseManager.calculateTotalForCategory("Sport"));
    }
    @Test
    void testCalculateTotalInDollars() throws ConnectException {
        ExpenseRepository mockedExpenseRepository = mock(ExpenseRepository.class);
        FancyService mockedFancyService = mock(FancyService.class);

        Expense expense1 = new Expense();
        expense1.setAmount(400);
        Expense expense2 = new Expense();
        expense2.setAmount(600);
        List<Expense> expenses = Arrays.asList(expense1, expense2);
        when(mockedExpenseRepository.getExpenses()).thenReturn(expenses);
        when(mockedFancyService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(invocation -> {
            double amount = invocation.getArgument(0);
            return amount / 4;
        });
        ExpenseManager expenseManager = new ExpenseManager(mockedExpenseRepository, mockedFancyService);
        long totalInDollars = expenseManager.calculateTotalInDollars();
        assertEquals(250, totalInDollars);
    }
}
