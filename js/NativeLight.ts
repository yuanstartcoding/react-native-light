import { TurboModuleRegistry } from "react-native";
import type { TurboModule } from "react-native/Libraries/TurboModule/RCTExport";

export interface Spec extends TurboModule {
  turnLightOn(): void;
  turnLightOff(): void;
}

export default TurboModuleRegistry.get<Spec>("RTNLight") as Spec | null;
