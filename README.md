This idea might be useful to help get less people infected with dengue, or fall victim to crime, if we put the hotspots as dengue cluster or crime cluster instead. Would be a good visualisation tool too.

## Super Quick Summary
Think of it as being the WeChat for covid-19. One app that does it all!

## Why is this important
The current TraceTogether app already have good traction and it helps to reduce the cost of contact tracing. Thus, working on top of it and make it better and more widely adopted would be a cost effective move, since every new adoption increase the effectiveness of the app exponentially. 
TraceTogether is the main app and that promotes the "strength in unity" narrative. On top of that have we have ScareAway that promotes the "keep yourself safe" narrative. If people download TraceTogether because of the ScareAway features that what we achieve is to have TraceTogether as the Trojan Horse into the users phone. The same concept applies to the other "convenience" narrative 

## Inspiration
As all human have self-preservative instinct, we should leverage on that to our advantage to:
1. get more people to download and use the app;
2. reduce the number of people going out especially to places where known cases have traveled to, to reduce the risk of new infections;
3. reduce the number of people taking the same path of potential cases to reduce the risk of new infections;
4. auto redistribution effect where when cases increase, people whom are out there will be lower.

As all human will tend to go for convenience, we should leverage on that to our advantage to:
1. get more people to download and use the app;

## Features to leverage on self-preservative instinct
Quick summary: Adding hotspot and geofencing features to TraceTogether app so that people can have the choice to decide if they really wanna hang out or go to that hotspot. This add an additional narrative to speak to a majority of the people whom are scare and do not want to contract the virus, to download the app, so that they can avoid high risk area. This also reduce the crowd in a high risk area, thus reducing the probability of contracting the virus.

**Details**
- Hotspot of all the current known cases and cluster with level of severity:
    - Heatmap coloring
        - newly found case will be red
        - after 14 days and no new cases link to that spot will be orange
        - after 28 days and no new cases link to that spot will be yellow
        - after 42 days and no new cases link to that spot will be cleared
    - Option to let people turn on and off location service so they will have a dot on the map to more easily identify if they are close
    - So people whom have no real need to be there, will not stay or go to that places, and risk getting the virus from people whom are there frequently
- Geofencing of all know cases and cluster and notify the user when they are entering a hotspot:
    - So people whom have no real need to be there, will not stay or go to that places, and risk getting the virus from people whom are there frequently
    - Option to let people turn on and off location service for this feature
- Since user whom are in close contact with new cases are immediately notified if they are close contact with newly diagnosed cases, some prompt could be included to help ScareAway people
    - A choice for them to turn on location to leave a trail so people will avoid walking that path to reduce the risk of getting the virus that may be lingering in the air or surface of objects
    - A choice for them add another json key-pair (e.g. "cc": 1) to indicate to other phone that they are identified as close-contact with a confirm case, so the other phone will get a notification to avoid staying nearby for too long and should move away
    - this also helps if the person is suppose to stay at home and they get out of the homes with their phones on them, so people can avoid them

## Features to leverage on convenience
Quick summary: Look at current services that those people whom did not install the app will need or want and integrate it to the app and make it more convenient so as to entice them to download it. e.g. one click SafeEntry. 

**Details**
- Going to mall and place requires the person to either scan their IC barcode, or use the QR code. If we allow the choice of using the TraceTogether app to verify their check in and out and make it more convenient then the other options, that would increase the chance of user downloading the app.
    - could be done by installing a laptop version of the TraceTogether (all mall now have a laptop to scan the IC), and if you are near the laptop the TraceTogether app can verify you are checked in. Your phone shows that you are check in, you show the staff and walk in.
    - no need to find your wallet and IC, no need to use many apps just to get the QR code check-in working
- Create portable keychain beacons devices that uses the BlueTrace protocol so that seniors that don't have phone still can be part of the TraceTogether ecosystem. 
- Integrating features such as MaskGoWhere or whatever covid-19 related services to increase the stickiness of the app.

## How to test if it works
- Survey with current user on the ScareAway narrative, benefits & feature and check on the acceptance rate, the rate where they will share and the rate that they will install for their immediate contact.
- A/B testing of promotional material one talking about the TraceTogether feature, one about ScareAway narrative, benefits & feature and check the conversion rate.
- Run a POC and place marketing material to promote one-click SafeEntry at a mall with a QR-code to download the app (embedded with a tracking id so you know user download the app as they saw the marketing material). Of course it will end up saying it is a market test, and ask them to click subscribe to get notified when the app is ready. check the scan rate and subscribe rate to determine if it is worth the effort to go ahead.

## Potential challenges
- If a group of people are super against the idea of having the location and will not download if the app permission includes the work location, we might need the ScareAway app as a standalone app with same base code as TraceTogether but with the additional features.

## What's next for Improving the adoption and data collected by TraceTogether
