
let toggle_window_open = false;
function toggleChat() {
  const chatWindow = document.getElementById('toggle-window');
  toggle_window_open = !toggle_window_open;
  if (toggle_window_open) {
    chatWindow.style.display = 'block';
    chatMessages.scrollTop = chatMessages.scrollHeight;
  } else {
    chatWindow.style.display = 'none';
  }
}