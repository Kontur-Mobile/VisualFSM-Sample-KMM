import SwiftUI
import shared

@main
struct iosAppApp: App {
    
    @StateObject var authFeature = ObservableAuthFeature()
    
    var body: some Scene {
        WindowGroup {
            window
                .environmentObject(authFeature)
        }
    }
    
    @ViewBuilder
    var window: some View {
        switch authFeature.state {
        case .login(let data):
            AuthView(email: data.email, password: data.password, error: data.error, loading: false)
        case .authenticating(let data):
            AuthView(email: data.email, password: data.password, error: data.error, loading: true)
        case .registration(let data):
            RegistrationView(email: data.email, password: data.password, repeatedPassword: data.repeatedPassword, error: data.error, loading: true, showConfirmation: false)
        case .registering(let data):
            RegistrationView(email: data.email, password: data.password, repeatedPassword: data.password, error: data.error, loading: true, showConfirmation: false)
        case .confirmationRequested(let data):
            RegistrationView(email: data.email, password: data.password, repeatedPassword: data.password, error: data.error, loading: true, showConfirmation: true)
        case .userAuthorized(let data):
            UserAuthorizedView(email: data.email)
        }
    }
}
