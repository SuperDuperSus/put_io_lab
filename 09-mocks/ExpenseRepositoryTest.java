package put.io.testing.mocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import put.io.students.fancylibrary.database.IFancyDatabase;
import java.util.Collections;
import static org.mockito.Mockito.*;

public class ExpenseRepositoryTest {
    @Test
    void testload1() {
        MyDatabase dataBase = new MyDatabase();
        ExpenseRepository expenseRepository = new ExpenseRepository(dataBase);
        expenseRepository.loadExpenses();
        Assertions.assertTrue(expenseRepository.getExpenses().isEmpty());
    }
    @Test
    void testload2() {
        IFancyDatabase mockedObject = mock(IFancyDatabase.class);
        when(mockedObject.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expenseRepository = new ExpenseRepository(mockedObject);
        expenseRepository.loadExpenses();
        InOrder inOrder = inOrder(mockedObject);
        inOrder.verify(mockedObject).connect();
        inOrder.verify(mockedObject).queryAll();
        inOrder.verify(mockedObject).close();
        Assertions.assertTrue(expenseRepository.getExpenses().isEmpty());
    }
    @Test
    void testsave1() {
        IFancyDatabase mockedObject = mock(IFancyDatabase.class);
        ExpenseRepository expenseRepository = new ExpenseRepository(mockedObject);

        for (int i = 0; i < 5; i++) {
            expenseRepository.addExpense(new Expense());
        }
        expenseRepository.saveExpenses();
        verify(mockedObject, times(5)).persist(any(Expense.class));
    }
}
