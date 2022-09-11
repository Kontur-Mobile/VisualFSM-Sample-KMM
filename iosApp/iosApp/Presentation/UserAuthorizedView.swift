import SwiftUI

struct UserAuthorizedView: View {
    @EnvironmentObject var authFeature: ObservableAuthFeature

    private var email = ""

    init(email: String) {
        self.email = email
    }
    
    var body: some View {
        ScrollView {
            VStack(spacing: 16) {
                Text("Welcome!")
                    .font(.title)
                    .padding(.top, 128)
                Text(email)
                Button("Log out") {
                    withAnimation {
                        authFeature.logout()
                    }
                }.padding(.top, 32)
            }
        }
    }
}

struct UserAuthorizedView_Previews: PreviewProvider {
    static var previews: some View {
        UserAuthorizedView(email: "test")
    }
}
