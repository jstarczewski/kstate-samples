import Foundation
import SwiftUI
import common

@propertyWrapper
struct StateStateHolder<StateHolder>: DynamicProperty where StateHolder: common.StateHolder {

    @StateObject private var stateHolderObservable: ObservableStateHolder<StateHolder>

    init(wrappedValue: StateHolder) {
        _stateHolderObservable = StateObject(wrappedValue: ObservableStateHolder(wrappedValue))
    }

    var wrappedValue: StateHolder {
        get { return stateHolderObservable.stateHolder }
        set { stateHolderObservable.stateHolder = newValue }
    }

    var projectedValue: ObservedObject<ObservableStateHolder<StateHolder>>.Wrapper {
        self.$stateHolderObservable
    }
}
