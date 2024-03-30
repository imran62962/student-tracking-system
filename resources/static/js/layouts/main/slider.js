let isSliderRunning = true;
let slideIndex = 0;
let slideInterval;

// Load slides from local storage on page load
/*
window.onload = function () {
  const storedSlides = localStorage.getItem("slides");
  if (storedSlides) {
    document.getElementById("slides").innerHTML = storedSlides;
    updateTagNumbers();
  }
  updateSlider();
};
*/
function startStopSlider() {
    if (isSliderRunning) {
      clearInterval(slideInterval);
    } else {
      slideInterval = setInterval(nextSlide, 8000);
    }
    isSliderRunning = !isSliderRunning;
  }

function startSlider() {
  if (!isSliderRunning) {
    slideInterval = setInterval(nextSlide, 8000);
    isSliderRunning = true;
  }
}

function stopSlider() {
  if (isSliderRunning) {
    clearInterval(slideInterval);
    isSliderRunning = false;
  }
}

function addSlide() {
  const imageUrl = prompt("Enter slide imageUrl:");

  if (imageUrl !== "") {
    const description = prompt("Enter slide description (optional):");

    const newSlide = document.createElement("div");
    newSlide.className = "slide";
    if (description !== null) {  //Description provided
      if (description.trim() !== "") { ////Description empty
        newSlide.innerHTML = `<div class="tag">${getSlideNumber()} - ${description}</div><img src="${imageUrl}" alt="Slide" onclick="startStopSlider()">`;
      } else {
        newSlide.innerHTML = `<div class="tag">${getSlideNumber()} - No description</div><img src="${imageUrl}" alt="Slide" onclick="startStopSlider()">`;
      }
    } else {
      newSlide.innerHTML = `<div class="tag">${getSlideNumber()} - No description</div><img src="${imageUrl}" alt="Slide" onclick="startStopSlider()">`;
    }

    document.getElementById("slides").appendChild(newSlide);
    saveSlides();
    updateTagNumbers();
    updateSlider();
  } else {
    alert("Please enter a valid image URL.");
  }
}

function deleteSlide() {
  const slideNumber = prompt("Enter slide number to delete:");
  if (slideNumber !== null) {
    const index = parseInt(slideNumber) - 1;
    const slides = document.querySelectorAll(".slide");
    if (index >= 0 && index < slides.length) {
      document.getElementById("slides").removeChild(slides[index]);
      saveSlides();
      updateTagNumbers();
      updateSlider();
    } else {
      alert("Invalid slide number");
    }
  }
}

function deleteAllSlides() {
  const confirmDelete = confirm("Are you sure you want to delete all slides?");
  if (confirmDelete) {
    document.getElementById("slides").innerHTML = "";
    localStorage.removeItem("slides");
    updateSlider();
  }
}

function nextSlide() {
  const totalSlides = document.querySelectorAll(".slide").length;
  if (slideIndex === totalSlides - 1) {
    document.getElementById("slides").style.transition = "none";
    slideIndex = 0;
    updateSlider();
    setTimeout(() => {
      document.getElementById("slides").style.transition =
        "transform 0.5s ease-in-out";
    }, 0);
  } else {
    slideIndex++;
    updateSlider();
  }
}

function prevSlide() {
  const totalSlides = document.querySelectorAll(".slide").length;
  if (slideIndex === 0) {
    document.getElementById("slides").style.transition = "none";
    slideIndex = totalSlides - 1;
    updateSlider();
    setTimeout(() => {
      document.getElementById("slides").style.transition =
        "transform 0.5s ease-in-out";
    }, 0);
  } else {
    slideIndex--;
    updateSlider();
  }
}

function updateSlider() {
  const slideWidth = document.querySelector(".slide").offsetWidth;
  document.getElementById("slides").style.transform = `translateX(-${
    slideIndex * slideWidth
  }px)`;
}

function saveSlides() {
  const slidesHTML = document.getElementById("slides").innerHTML;
  localStorage.setItem("slides", slidesHTML);
}

function getSlideNumber() {
  return document.querySelectorAll(".slide").length + 1;
}

function updateTagNumbers() {
  const tags = document.querySelectorAll(".tag");
  tags.forEach((tag, index) => {
    tag.innerHTML = `${index + 1} - ${tag.innerText.split(" - ")[1]}`;
  });
}

slideInterval = setInterval(nextSlide, 2000); // Start the slider initially

/**/