import LoginForm from "./loginForm";

export default function LoginPage(props) {
    return <LoginForm setAuth={props.setAuth}/>
}