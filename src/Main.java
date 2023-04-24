import exceptions.*;

public class Main {
    public static void reg(String login, String password, String confirmPassword){
        String regex = "^[a-zA-Z0-9_]*$";
        if (login.length() > 20){
            throw new WrongLoginException();
        }
        if (password.length() > 20){
            throw new WrongPasswordLengthException();
        }
        if (password != confirmPassword){
            throw new WrongPasswordException();
        }
        if ((password.matches(regex)&&login.matches(regex)&&confirmPassword.matches(regex)) ==false){
            throw new WrongCharsException();
        }
    }

    public static void main(String[] args) {
        try {
            reg("145645_6479", "1", "1");
        }catch (WrongLoginException e){
            System.out.println("неправильный логин");
        }
        catch (WrongPasswordLengthException e){
            System.out.println("неправильный пароль");
        }

        catch (WrongPasswordException e){
            System.out.println("пароль не совпадает ");
        }
        catch (WrongCharsException e){
            System.out.println("обнаружены недопустимые символы  ");
        }
        finally {
            System.out.println("Конец");
        }
    }
}
