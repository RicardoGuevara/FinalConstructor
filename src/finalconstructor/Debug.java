/*
 * Copyright 2018 RICARDO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalconstructor;

/**
 *
 * @author RICARDO
 */
public interface Debug {
    
    //set on false to clean the debug in excecution time
    final boolean DEBUG_IS_ABLE = true;
    
    /**
     * makes the "hard-debug" more organized and easy to clean
     * @param debugables _ all the debug objects
     */
    public static void debugPrintln(Object ... debugables)
    {
        try {
            if (DEBUG_IS_ABLE) 
            {
                String finalPrint="";
                for (Object debugable : debugables) 
                {
                    finalPrint += debugable.toString();
                }
                
                System.out.println(finalPrint);
            }
        }
        catch(NullPointerException npe) 
        {
            System.out.println("NULL OBJECT AT:");
            npe.printStackTrace();
        }
        
        catch(Exception e)
        {
            System.out.println("SOMETHING GONE WRONG... SOME WHERE... WHENEVER... ( -.-)");
            e.printStackTrace();
        }
        catch(Throwable t)
        {
            System.out.println("I DON'T KNOW HOW CAN THIS HAPEND BUT IS A THROWABLE THING, WELL I SUPOSE, KILL ME PLEASSSSE");
            t.printStackTrace();
        }
    }
}
