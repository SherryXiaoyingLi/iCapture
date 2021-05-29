import LoginForm from "./loginForm";

export default function Login(props) {
    return <LoginForm setAuth={props.setAuth}/>
}