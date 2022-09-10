import SwiftUI

struct UserAuthorizedView: View {
    @EnvironmentObject var authFeature: ObservableAuthFeature

    @State private var email = ""

    init(email: String) {
        self.email = email
    }
    
    var body: some View {
        ScrollView {
            VStack(spacing: 32) {
                Text("Hello, World!")
                    .font(.title)
                    .padding(.top, 100)
                Button("Log out") {
                    withAnimation {
                        authFeature.logout()
                    }
                }
            }
        }
    }
}

struct UserAuthorizedView_Previews: PreviewProvider {
    static var previews: some View {
        UserAuthorizedView(email: "test")
    }
}
