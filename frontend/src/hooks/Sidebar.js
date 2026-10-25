const isTopWindow = window.parent === window;

function isDesktop() {
  return window.innerWidth >= 1024;
}

function openSidebar() {
  if (!isTopWindow) return;
  const sidebar = document.querySelector(".sidebar-iframe");
  const backdrop = document.querySelector(".sidebar-backdrop");
  if (!sidebar) return;
  sidebar.classList.add("open");
  sidebar.setAttribute("aria-hidden", "false");
  if (backdrop) {
    backdrop.classList.add("visible");
  }
}

function closeSidebar() {
  if (!isTopWindow) return;
  // Não fecha a sidebar em desktop
  if (isDesktop()) return;

  const sidebar = document.querySelector(".sidebar-iframe");
  const backdrop = document.querySelector(".sidebar-backdrop");
  if (!sidebar) return;
  sidebar.classList.remove("open");
  sidebar.setAttribute("aria-hidden", "true");
  if (backdrop) {
    backdrop.classList.remove("visible");
  }
}

function toggleSidebar() {
  if (!isTopWindow) return;
  const sidebar = document.querySelector(".sidebar-iframe");
  if (!sidebar) return;
  if (sidebar.classList.contains("open")) {
    closeSidebar();
  } else {
    openSidebar();
  }
}

function handleHeaderClick() {
  const button = document.querySelector(".menuHamburguer");
  if (!button) return;

  button.addEventListener("click", () => {
    const expanded = button.getAttribute("aria-expanded") === "true";
    button.setAttribute("aria-expanded", String(!expanded));
    if (window.parent && window.parent !== window) {
      window.parent.postMessage({ type: "toggle-sidebar" }, "*");
    }
  });
}

function handleSidebarLinks() {
  const links = document.querySelectorAll("nav a");
  if (!links || links.length === 0) return;
  links.forEach((link) => {
    link.addEventListener("click", () => {
      // Não fecha a sidebar em desktop
      if (!isDesktop() && window.parent && window.parent !== window) {
        window.parent.postMessage({ type: "close-sidebar" }, "*");
      }
    });
  });
}

function handleBackdropClick() {
  const backdrop = document.querySelector(".sidebar-backdrop");
  if (!backdrop) return;
  backdrop.addEventListener("click", () => {
    closeSidebar();
  });
}

function handleMessages() {
  window.addEventListener("message", (event) => {
    if (!event.data || !event.data.type) return;
    const type = event.data.type;
    if (type === "toggle-sidebar") toggleSidebar();
    else if (type === "close-sidebar") closeSidebar();
    else if (type === "open-sidebar") openSidebar();
  });
}

function checkScreenSize() {
  if (isDesktop()) {
    openSidebar();
  } else {
    closeSidebar();
  }
}

function handleWindowResize() {
  window.addEventListener("resize", checkScreenSize);
}

if (isTopWindow) {
  handleMessages();
  handleBackdropClick();
  handleWindowResize();
  checkScreenSize();
} else {
  // inside an iframe: could be header or sidebar
  if (document.querySelector(".menuHamburguer")) {
    handleHeaderClick();
  }
  if (document.querySelector("nav.sidebar")) {
    handleSidebarLinks();
  }
}
