import SwiftUI
import shared

class ObservableAuthFeature: ObservableObject {
    @Published private(set) var state: AuthState
    
    private let feature: AuthFeature
    
    var stateWatcher : Closeable?

    init() {
        self.feature = AuthFeature(initialState: AuthFSMState.Login(mail: "", password: "", errorMessage: "", snackBarMessage: ""))

        self.state = AuthState(feature.getCurrentState())

        stateWatcher = self.feature.watchState().watch { [weak self] state in
            self?.state = AuthState(state)
        }
    }
    
    public func toRegistration() {
        feature.toRegistration()
    }
    
    public func toLogin() {
        feature.toLogin()
    }

    public func logout() {
        feature.logout()
    }
    
    public func confirmRegistrationData() {
        feature.confirmRegistrationData()
    }
    
    public func declineRegistrationData() {
        feature.declineRegistrationData()
    }
    
    public func startAuthenticating() {
        feature.startAuthenticating()
    }
    
    public func startRegistration() {
        feature.startRegistration()
    }
    
    public func handleChangeLoginData(mail: String, password: String) {
        feature.handleChangeLoginData(mail: mail, password: password)
    }
    
    public func handleChangeRegistrationData(mail: String, password: String, repeatPassword: String) {
        feature.handleChangeRegistrationData(mail: mail, password: password, repeatPassword: repeatPassword)
    }
    
    deinit {
        stateWatcher?.close()
    }
}
