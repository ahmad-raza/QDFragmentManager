# QDFragmentManager

## Usage

QDFragmentManager is a android java control that will hep developers to integrate tabs and fragments inside their android application with best practices and less efforts. Developer would be able to create tabs and bind them with fragments inside same activity with writing few lines of code.

* QDFragmentManager keeps Tab-Specific stacks of fragments. If user navigate through different fragments and it moves to another tab and get back to previous. Application won't lost the last state of tab.
* QDFragmentManager allows user to adjust its tabs layout as required. User can move tabs view to top or bottom by dealing with simple property.

To run the example project, clone the repo, and open it in Android Studio, Run it :)


## Installation
You need to take care of following points in order to integrate QDFragmentManager inside your application:
* Inherit your Activity from QDActivity.
* Inherit all your Fragments from QDFragment.
* Forward position of your tab-view to super activity by calling super.onCreate() in your activity.
* Create tabs that you want to populate inside of onCreate() function of your activity. You can create tabs by simply callong addTab() function.

Hurrah, all setup. You're good to run your application.



#Manual
Add all files from QDFragmentManager/ to your project and follow the steps mentioned above for Installation.

## Author

Ahmad Raza, @Ahmad_Rza