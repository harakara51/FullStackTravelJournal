package controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Entities.Audio;
import Entities.Image;
import Entities.Location;
import Entities.Text;
import Entities.Trip;
import Entities.User;
import Entities.Video;
import data.TravelDAO;

@Controller
@SessionAttributes(
{ "user" })
public class TravelController
{

	@Autowired
	private TravelDAO travelDAO;

	@RequestMapping(path = "addtrip.do", method = RequestMethod.POST)
	public ModelAndView createTrip()
	{
		System.out.println("inside creating new trip method");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("newTrip.jsp");
		return mv;
	}

	@RequestMapping(path = "CreateTripDB.do", method = RequestMethod.POST)
	public ModelAndView createTripDB(@RequestParam("trip_name") String tripname,
			@RequestParam("date_started") String dateStarted, @RequestParam("date_ended") String dateEnded,
			@ModelAttribute("user") User user)
	{
		System.out.println("inside creating trip to db method");
		ModelAndView mv = new ModelAndView();
		travelDAO.createNewTrip(user, tripname, dateStarted, dateEnded);
		user = travelDAO.refreshUser(user);
		mv.addObject("user", user);
		mv.setViewName("dashboard.jsp");
		return mv;
	}

	@RequestMapping(path = "addlocation.do", method = RequestMethod.POST)
	public ModelAndView addLocation(@RequestParam("trip_id") int tripId)
	{
		System.out.println("inside creating new location method");
		// System.out.println(tripId);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("newLocation.jsp");
		mv.addObject("trip_id", tripId);
		return mv;
	}

	@RequestMapping(path = "CreateLocationDB.do", method = RequestMethod.POST)
	public ModelAndView createLocationDB(@RequestParam("trip_id") int tripId,
			@RequestParam("location_name") String locationName, @RequestParam("city") String city,
			@RequestParam("country") String country, @RequestParam("date_started") String dateStarted,
			@RequestParam("date_ended") String dateEnded, @RequestParam("audio_src") String audioSrc,
			@RequestParam("audio_text") String audioText, @RequestParam("video_src") String videoSrc,
			@RequestParam("video_txt") String videoText, @RequestParam("img_src1") String imgSrc1,
			@RequestParam("img_txt1") String imgText1, @RequestParam("img_src2") String imgSrc2,
			@RequestParam("img_txt2") String imgText2, @RequestParam("img_src3") String imgSrc3,
			@RequestParam("img_txt3") String imgText3, @RequestParam("img_src4") String imgSrc4,
			@RequestParam("img_txt4") String imgText4, @RequestParam("text_body") String textBody,
			@ModelAttribute("user") User user

	)
	{

		System.out.println("inside creating location to db method");
		Trip tempTrip = travelDAO.findTripById(tripId);

		ModelAndView mv = new ModelAndView();

		Location loc = travelDAO.creatNewLocation(tempTrip, locationName, city, country, dateStarted, dateEnded);

		travelDAO.creatNewAudio(loc, audioSrc, audioText);

		travelDAO.creatNewImage(loc, imgSrc1, imgText1);
		travelDAO.creatNewImage(loc, imgSrc2, imgText2);
		travelDAO.creatNewImage(loc, imgSrc3, imgText3);
		travelDAO.creatNewImage(loc, imgSrc4, imgText4);
		travelDAO.creatNewVideo(loc, videoSrc, videoText);
		travelDAO.creatNewText(loc, textBody);
		user = travelDAO.refreshUser(user);
		mv.addObject("user", user);
		mv.setViewName("dashboard.jsp");
		return mv;
	}

	@RequestMapping(path = "updateLocationDB.do", method = RequestMethod.POST)
	public ModelAndView updateLocationDB(@RequestParam("trip_id") int tripId, @RequestParam("location_id") int locationId,
			@RequestParam("location_name") String locationName, @RequestParam("city") String city,
			@RequestParam("country") String country, @RequestParam("date_started") String dateStarted,
			@RequestParam("date_ended") String dateEnded, @RequestParam("audio_src") String audioSrc,
			@RequestParam("audio_text") String audioText, @RequestParam("video_src") String videoSrc,
			@RequestParam("video_txt") String videoText, @RequestParam("img_src1") String imgSrc1,
			@RequestParam("img_txt1") String imgText1, @RequestParam("img_src2") String imgSrc2,
			@RequestParam("img_txt2") String imgText2, @RequestParam("img_src3") String imgSrc3,
			@RequestParam("img_txt3") String imgText3, @RequestParam("img_src4") String imgSrc4,
			@RequestParam("img_txt4") String imgText4, @RequestParam("text_body") String textBody,
			@ModelAttribute("user") User user
	)
	{
		System.out.println("WE ARE UPDATING");
		Trip trip = travelDAO.findTripById(tripId);
		ModelAndView mv = new ModelAndView();
		Location loc = travelDAO.findLocationById(locationId);
		loc.setLocationName(locationName);
		loc.setTrip_id(trip);
		loc.setCity(city);
		loc.setCountry(country);
		loc.setDateStarted(dateStarted);
		loc.setDatEnded(dateEnded);
		Collection<Audio> aud = loc.getAudios();
		Collection<Text> txt = loc.getTexts();
		Collection<Video> vid = loc.getVideos();
		ArrayList<Image> img = loc.getImages();
		String[] imgsrcs = {imgSrc1,imgSrc2,imgSrc3,imgSrc4};
		String[] imgtexts = {imgText1,imgText2,imgText3,imgText4};
		
		for (Audio a : aud) {
			a.setAudio_src(audioSrc);
			a.setAudio_text(audioText);
		}
		for (int i=0; i < img.size(); i++) {
			
			img.get(i).setImg_src(imgsrcs[i]);
			img.get(i).setImg_text(imgtexts[i]);
		}
		for (Text t : txt) {
			t.setBigtext(textBody);
		}
		for (Video v : vid) {
			v.setVideo_src(videoSrc);
			v.setVideo_text(videoText);
		}
		
System.out.println(loc);

		travelDAO.updateLocation(loc);
		user = travelDAO.refreshUser(user);
		mv.addObject("user", user);
		mv.setViewName("dashboard.jsp");
		return mv;
	}
	
	@RequestMapping(path = "loadDashboard.do", method = RequestMethod.GET)
	public ModelAndView loadDashboard()
	{

		System.out.println("inside creating trip to db method");

		ModelAndView mv = new ModelAndView();
		mv.addObject("user");
		mv.setViewName("dashboard.jsp");
		return mv;
	}

	@RequestMapping(path = "deletelocation.do", method = RequestMethod.POST)
	public ModelAndView deleteLocation(@RequestParam("location_id") int locationId, @RequestParam("trip_id") int tripId,
			@ModelAttribute("user") User user)
	{

		System.out.println("inside method to delete location");
		Trip trip = travelDAO.findTripById(tripId);
		Location loc = travelDAO.findLocationById(locationId);

		travelDAO.deleteLocationById(trip, locationId);
		ModelAndView mv = new ModelAndView();
		user = travelDAO.refreshUser(user);
		mv.addObject("user", user);

		mv.setViewName("dashboard.jsp");
		return mv;
	}

	@RequestMapping(path = "editlocation.do", method = RequestMethod.POST)
	public ModelAndView editLocation(@RequestParam("location_id") int locationId, @ModelAttribute("user") User user)
	{
		System.out.println("inside creating trip to db method");
		Location loc = travelDAO.findLocationById(locationId);

		ModelAndView mv = new ModelAndView();
		user = travelDAO.refreshUser(user);
		mv.addObject("location", loc);
		mv.setViewName("editView.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteTrip.do", method = RequestMethod.POST)
	public ModelAndView deleteTrip(@RequestParam("trip_id") int tripId, @ModelAttribute("user") User user)
	{

		System.out.println("inside method to delete location");
		travelDAO.deleteTripById(user, tripId);
		ModelAndView mv = new ModelAndView();
		user = travelDAO.refreshUser(user);
		mv.addObject("user", user);
		mv.setViewName("dashboard.jsp");
		return mv;
	}
	
	@RequestMapping(path = "editlocations.do", method = RequestMethod.POST)
	public ModelAndView editLocation(@RequestParam("location_id") int location_id)
	{

	System.out.println("inside method to edit location");

	Location Loc =travelDAO.findLocationById(location_id);
	ModelAndView mv = new ModelAndView();
	mv.addObject("location", Loc);
	mv.setViewName("editLocation.jsp");
	return mv;

	}


	@RequestMapping(path = "nextLocation.do", method = RequestMethod.POST)
	public ModelAndView nextLocation(@RequestParam("location_id") int locationId)
	{

		Location loc = travelDAO.findLocationById(locationId);

		Trip trip = loc.getTrip_id();

		ArrayList<Location> locs = trip.getLocations();

		int i = locs.indexOf(loc);
		if ((i + 1) == locs.size())
		{
			ModelAndView mv = new ModelAndView();

			mv.addObject("location", loc);

			mv.setViewName("editView.jsp");
			return mv;

		} else
		{
			Location toReturn = locs.get(i + 1);
			ModelAndView mv = new ModelAndView();
			mv.addObject("location", toReturn);

			mv.setViewName("editView.jsp");
			return mv;

		}

	}
	
	@RequestMapping(path = "previousLocation.do", method = RequestMethod.POST)
	public ModelAndView previousLocation(@RequestParam("location_id") int locationId)
	{
System.out.println(locationId);
		Location loc = travelDAO.findLocationById(locationId);
		Trip trip = loc.getTrip_id();
		ArrayList<Location> locs = trip.getLocations();
		int i = locs.indexOf(loc);
		
		if (i == 0)
		{
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("location", loc);
			mv.setViewName("editView.jsp");
			return mv;

		} else
		{
			
			Location toReturn = locs.get(i-1);
			ModelAndView mv = new ModelAndView();
			mv.addObject("location", toReturn);
			mv.setViewName("editView.jsp");
			return mv;

		}

	}

}
