import SwiftUI

struct AuthView: View {
    @EnvironmentObject var authFeature: ObservableAuthFeature
    
    @State private var email = ""
    @State private var password = ""
    private let error: String?
    private let loading: Bool

    init(email: String, password: String, error: String?, loading: Bool) {
        self.email = email
        self.password = password
        self.error = error
        self.loading = loading
    }
    
    var body: some View {
        GeometryReader { geometry in
            ScrollView(showsIndicators: false) {
                VStack {
                    Spacer()
                    Text("Login")
                        .font(.title2)
                    
                    VStack(spacing: 40) {
                        CustomInputField(imageName: "envelope", placeholderText: "Email", text: $email, secured: false)
                        CustomInputField(imageName: "lock", placeholderText: "Password", text: $password, secured: true)
                        if let error = error {
                            Text(error)
                                .foregroundColor(.red)
                                .bold()
                        }
                    }
                    .padding(.horizontal, 32)
                    .padding(.top, 44)
                    
                    HStack {
                        Spacer()
                        Button() {
                            authFeature.toRegistration()
                        } label: {
                            Text("Sign Up")
                                .font(.caption)
                                .bold()
                                .padding(.top)
                                .padding(.trailing, 24)
                        }
                    }
                    
                    AuthButton("Sign In", showProgress: authFeature.state.inProgress) {
                        authFeature.startAuthenticating()
                    }
                    
                    Spacer()
                }
                .frame(minHeight: geometry.size.height)
            }
        }.onChange(of: email) { newValue in
            authFeature.handleChangeLoginData(mail: newValue, password: password)
        }.onChange(of: password) { newValue in
            authFeature.handleChangeLoginData(mail: email, password: newValue)
        }
    }
}
struct AuthView_Previews: PreviewProvider {
    static var previews: some View {
        AuthView(email: "", password: "", error: nil, loading: false)
            .environmentObject(ObservableAuthFeature())
    }
}
