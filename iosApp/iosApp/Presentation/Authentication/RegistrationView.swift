import SwiftUI

struct RegistrationView: View {
    @EnvironmentObject var authFeature: ObservableAuthFeature

    @State var showConfirmation: Bool
    @State private var email = ""
    @State private var password = ""
    @State private var repeatPassword = ""
    private let error: String?
    private let loading: Bool

    init(email: String, password: String, repeatedPassword: String, error: String?, loading: Bool, showConfirmation: Bool) {
        self.email = email
        self.password = password
        self.error = error
        self.loading = loading
        self._showConfirmation = State(initialValue: showConfirmation)
    }
    
    
    var body: some View {
        GeometryReader { geometry in
            ScrollView(showsIndicators: false) {
                VStack {
                    Spacer()
                    Text("Registration")
                        .font(.title2)

                    VStack(spacing: 40) {
                        CustomInputField(imageName: "envelope", placeholderText: "Email", text: $email)
                        CustomInputField(imageName: "lock", placeholderText: "Password", text: $password)
                        CustomInputField(imageName: "lock", placeholderText: "Repeat password", text: $repeatPassword)
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
                            authFeature.toLogin()
                        } label: {
                            Text("Sign In")
                                .font(.caption)
                                .bold()
                                .padding(.top)
                                .padding(.trailing, 24)
                        }
                    }

                    AuthButton("Sign Up", showProgress: authFeature.state.inProgress) {
                        authFeature.startRegistration()
                    }

                    Spacer()
                }
                .frame(minHeight: geometry.size.height)
            }
        }
        .confirmationDialog("Confirm registration", isPresented: $showConfirmation) {
            Button("OK") {
                authFeature.confirmRegistrationData()
            }
            Button("Cancel", role: .cancel) {
                authFeature.declineRegistrationData()
            }
        } message: {
            Text("Continue with current data?")
        }
        .onChange(of: email) { newValue in
            authFeature.handleChangeRegistrationData(mail: newValue, password: password, repeatPassword: repeatPassword)
        }.onChange(of: password) { newValue in
            authFeature.handleChangeRegistrationData(mail: email, password: newValue, repeatPassword: repeatPassword)
        }.onChange(of: repeatPassword) { newValue in
            authFeature.handleChangeRegistrationData(mail: email, password: password, repeatPassword: newValue)
        }
    }
}
