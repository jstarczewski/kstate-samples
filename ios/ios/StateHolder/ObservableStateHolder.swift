import Foundation
import common

class ObservableStateHolder<StateHolder>: ObservableObject where StateHolder: common.StateHolder {

    var stateHolder: StateHolder

    init(_ stateHolder: StateHolder) {
        self.stateHolder = stateHolder
        self.stateHolder.binder.objectWillChange = { [weak self] in
            DispatchQueue.main.async {
                self?.objectWillChange.send()
            }
        }
    }
}
