import SwiftUI
import shared

struct ContentView: View {
    let calculator = Calculator.Companion()
    let projectService = (koin.get(objCClass: ProjectService.self) as! ProjectService)
    
    @State private var firstNum: String = "0"
    @State private var secondNum: String = "0"
    private var sum: String {
        if let firstNum = Int32(firstNum), let secondNum = Int32(secondNum) {
            return String(calculator.sum(a: firstNum, b: secondNum))
        } else {
            return "🤔"
        }
    }
    
    var body: some View {
        VStack(alignment: .center) {
            Text(projectService.getProject()?.language ?? "no Project")
            HStack(alignment: .center) {
                TextField("A", text: $firstNum)
                    .keyboardType(.numberPad)
                    .multilineTextAlignment(.center)
                    .frame(width: 30)
                Text("+")
                TextField("B", text: $secondNum)
                    .keyboardType(.numberPad)
                    .multilineTextAlignment(.center)
                    .frame(width: 30)
                Text("=")
                Text(sum)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
