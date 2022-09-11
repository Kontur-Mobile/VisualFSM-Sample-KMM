import SwiftUI

struct CustomInputField: View {
    let imageName: String
    let placeholderText: String
    @Binding var text: String
    let secured: Bool
    var body: some View {
        VStack {
            HStack {
                Image(systemName: imageName)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 20, height: 20)
                    .foregroundColor(Color(.darkGray))
                
                if(secured) {
                    SecureField(placeholderText, text: $text)
                } else {
                    TextField(placeholderText, text: $text)
                }
                
            }
            
            Divider()
                .background(Color(.darkGray))
        }
    }
}

struct CustomInputField_Previews: PreviewProvider {
    static var previews: some View {
        CustomInputField(imageName: "envelope",
                         placeholderText: "Email",
                         text: .constant(""),
                         secured: false)
    }
}
