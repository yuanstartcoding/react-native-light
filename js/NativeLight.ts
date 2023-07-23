import { TurboModuleRegistry } from "react-native";
import type { TurboModule } from "react-native/Libraries/TurboModule/RCTExport";

export interface Spec extends TurboModule {
  switchOn(): void;
  switchOff(): void;
  isFlashActive(): Promise<boolean>;
}

export default TurboModuleRegistry.get<Spec>("RTNLight") as Spec | null;
