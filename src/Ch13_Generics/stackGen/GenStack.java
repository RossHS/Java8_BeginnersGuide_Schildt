package Ch13_Generics.stackGen;

/**
 * Created by Ross on 24.10.2017.
 */
public class GenStack<T> implements IGenStack<T> {
    private T stack[]; //массив для хранения стека
    private int tos; //Вершина стека

    public GenStack(T[] stack) {
        this.stack = stack;
        tos = 0;
    }

    //создать стек из другого стека
    public GenStack(T[] stack, GenStack<T> obj) {
        this.tos = obj.tos;
        this.stack = stack;
        try {
            if (stack.length < obj.stack.length) {
                throw new StackFullException(stack.length);
            }
        } catch (StackFullException exc) {
            System.out.println(exc);
        }

        //копируем элементы
        for (int i = 0; i < tos; i++) {
            stack[i] = obj.stack[i];
        }
    }

    public GenStack(T[] stack, T[] a) {
        this.stack = stack;

        for (int i = 0; i < a.length; i++) {
            try {
                push(a[i]);
            } catch (StackFullException exc) {
                System.out.println(exc);
            }
        }
    }

    //Поместить объект в кучу
    @Override
    public void push(T obj) throws StackFullException {
        if (tos == stack.length) throw new StackFullException(stack.length);

        stack[tos] = obj;
        tos++;
    }

    //Извлечь объект
    @Override
    public T pop() throws StackEmptyException {
        if (tos == 0) {
            throw new StackEmptyException();
        }
        tos--;
        return stack[tos];
    }
}
