#import "RTNLightSpec.h"
#import "RTNLight.h"
#import "AVFoundation/AVFoundation.h"

@implementation RTNLight

RCT_EXPORT_MODULE()


- (void) switchOn
{
    [self on:true];
}

- (void) switchOff
{
    [self on:false];
}

- (void) on:(bool) on
{
    if ([AVCaptureDevice class]) {
        AVCaptureDevice *device = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
        if ([device hasTorch]){
            [device lockForConfiguration:nil];
            if (on) {
                [device setTorchMode:AVCaptureTorchModeOn];
            } else {
                [device setTorchMode:AVCaptureTorchModeOff];
            }
            [device unlockForConfiguration];
        }
    }
}

- (bool) isLightActive
{
    if ([AVCaptureDevice class]) {
        AVCaptureDevice *device = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
        if ([device hasTorch]){
            return [device isTorchActive];
        }else{
            return false;
        }
    }
    return false;
}



- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeLightSpecJSI>(params);
}

@end
