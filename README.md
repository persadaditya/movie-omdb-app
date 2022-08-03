# Movie OMDB API
Application that search movie from omdb api then see detail movie

### Kotlin MVVM
project that implements the MVVM architecture using Kotlin, Data Binding, RxJava2 and Android Architecture Components.


### Library reference resources:
1. Architecture Components: https://developer.android.com/topic/libraries/architecture/adding-components.html
2. RxJava2: https://github.com/ReactiveX/RxJava
3. Dagger2: https://github.com/google/dagger
4. Retrofit: https://github.com/square/retrofit

### Layers of the app:
 * Data - contains the model/business model that will be presented to the view, related classes included Reponse models, classes associated with the Room database library
 * DI - contains all the Dagger 2 injection classes.
 * UI - the actual Android UI components, Activities and ViewModels

### Starter
 *check your todo replace your apikey

### Add another feature
 #### for data
 * add your model in /data/model/response
 * add your endpoint /data/remote/ in ApiHelper
 * implement your AppRepo /data/repository

 #### for ui
 * create folder in ui/launch/your_added_feature
 * create fragment that extend BaseFragment 
 * crete view model that extend BaseViewModel


 ## License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
