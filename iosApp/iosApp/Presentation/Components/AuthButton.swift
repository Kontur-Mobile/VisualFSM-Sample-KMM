import SwiftUI

struct AuthButton: View {
    let title: String
    let showProgress: Bool
    let onTap: () -> Void

    init(_ title: String, showProgress: Bool, onTap: @escaping () -> Void) {
        self.title = title
        self.showProgress = showProgress
        self.onTap = onTap
    }

    var body: some View {
        Button(action: onTap) {
            Text(title)
                .opacity(showProgress ? 0 : 1)
                .overlay(showProgress ? ProgressView().tint(.white) : nil)
                .disabled(showProgress)
                .font(.headline)
                .frame(maxWidth: .infinity)
        }
        .buttonStyle(.borderedProminent)
        .controlSize(.large)
        .clipShape(Capsule())
        .padding(32)
        .shadow(color: .gray.opacity(0.5), radius: 10, x: 0, y: 0)
    }
}

struct AuthButton_Previews: PreviewProvider {
    static var previews: some View {
        AuthButton("Sign In", showProgress: false, onTap: {})
    }
}
