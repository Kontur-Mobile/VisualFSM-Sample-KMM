import shared

enum AuthState: Equatable {
    case login(LoginData)
    case registration(SignUpData)
    case confirmationRequested(LoginData)
    case authenticating(LoginData)
    case registering(LoginData)
    case userAuthorized(UserData)

    public init(_ obj: AuthFSMState) {
        if obj is AuthFSMState.Login {
            let login = obj as! AuthFSMState.Login
            self = .login(LoginData(email: login.mail, password: login.password, error: login.errorMessage))
        } else if obj is AuthFSMState.Registration {
            let registration = obj as! AuthFSMState.Registration
            self = .registration(SignUpData(email: registration.mail, password: registration.password, repeatedPassword: registration.repeatedPassword, error: registration.errorMessage))
        } else if obj is AuthFSMState.ConfirmationRequested {
            let confirmationRequested = obj as! AuthFSMState.ConfirmationRequested
            self = .confirmationRequested(LoginData(email: confirmationRequested.mail, password: confirmationRequested.password, error: nil))
        } else if obj is AuthFSMState.AsyncWorkStateAuthenticating {
            let authenticating = obj as! AuthFSMState.AsyncWorkStateAuthenticating
            self = .authenticating(LoginData(email: authenticating.mail, password: authenticating.password, error: nil))
        } else if obj is AuthFSMState.AsyncWorkStateRegistering {
            let registering = obj as! AuthFSMState.AsyncWorkStateRegistering
            self = .registering(LoginData(email: registering.mail, password: registering.password, error: nil))
        } else if obj is AuthFSMState.UserAuthorized {
            let userAuthorized = obj as! AuthFSMState.UserAuthorized
            self = .userAuthorized(UserData(email: userAuthorized.mail))
        } else {
          fatalError("AuthState not syncronized with AuthFSMState kotlin class")
        }
      }

    var inProgress: Bool {
        switch self {
        case .authenticating, .registering:
            return true
        default:
            return false
        }
    }

    struct SignUpData: Equatable {
        let email, password, repeatedPassword: String
        let error: String?
    }

    struct LoginData: Equatable {
        let email, password: String
        let error: String?
    }
    
    struct UserData: Equatable {
        let email: String
    }
}
